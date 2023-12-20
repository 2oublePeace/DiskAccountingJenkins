package com.emiryanvl.mainservice.service

import com.emiryanvl.mainservice.dto.response.DiskResponse
import com.emiryanvl.mainservice.dto.request.DiskRequest

interface DiskService {
    fun get(id: Long): DiskResponse
    fun getAll(): List<DiskResponse>
    fun create(request: DiskRequest): DiskResponse
    fun update(id: Long, request: DiskRequest) : DiskResponse
    fun delete(id: Long)
}