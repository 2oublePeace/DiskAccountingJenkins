package com.emiryanvl.diskaccounting.service.impl

import com.emiryanvl.diskaccounting.dto.request.DiskRequest
import com.emiryanvl.diskaccounting.dto.response.DiskResponse
import com.emiryanvl.diskaccounting.entity.DiskEntity
import com.emiryanvl.diskaccounting.repository.DiskRepository
import com.emiryanvl.diskaccounting.service.DiskService
import com.emiryanvl.diskaccounting.exception.NotFoundException.Companion.notFoundException
import org.springframework.stereotype.Service

@Service
class DiskServiceImpl(val diskRepository: DiskRepository) : DiskService {
    override fun get(id: Long): DiskResponse {
        val diskEntity = diskRepository.findById(id).orElseThrow(notFoundException("Диск $id не найден", id))
        return DiskResponse(diskEntity.title, diskEntity.isRented, diskEntity.id)
    }

    override fun getAll(): List<DiskResponse> {
        return diskRepository.findAll().map { DiskResponse(it.title, it.isRented, it.id) }
    }

    override fun create(request: DiskRequest): DiskResponse {
        val entity = diskRepository.save(DiskEntity(title = request.title, isRented = request.isRented))
        return DiskResponse(entity.title, entity.isRented, entity.id)
    }

    override fun update(id: Long, request: DiskRequest): DiskResponse {
        val diskEntity = diskRepository.save(
           editDisk(
               diskRepository.findById(id).orElseThrow(notFoundException("Диск $id не найден", id)),
               request
           )
        )
        return DiskResponse(diskEntity.title, diskEntity.isRented, diskEntity.id)
    }

    override fun delete(id: Long) {
        diskRepository.findById(id).ifPresentOrElse({ diskRepository.deleteById(id) }) {
            notFoundException("Диск $id не найден", id)
        }
    }

    fun editDisk(diskEntity: DiskEntity, diskRequest: DiskRequest): DiskEntity {
        return diskEntity.apply {
            this.title = diskRequest.title
            this.isRented = diskRequest.isRented
        }
    }
}