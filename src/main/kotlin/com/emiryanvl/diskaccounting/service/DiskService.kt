package com.emiryanvl.diskaccounting.service

import com.emiryanvl.diskaccounting.dto.response.DiskResponse
import com.emiryanvl.diskaccounting.dto.request.DiskRequest

interface DiskService {
    fun get(id: Long): DiskResponse
    fun getAll(): List<DiskResponse>
    fun create(request: DiskRequest): DiskResponse
    fun update(id: Long, request: DiskRequest) : DiskResponse
    fun delete(id: Long)
}