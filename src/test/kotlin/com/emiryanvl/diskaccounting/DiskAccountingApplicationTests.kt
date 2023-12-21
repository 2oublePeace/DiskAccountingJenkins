package com.emiryanvl.diskaccounting

import com.emiryanvl.diskaccounting.dto.request.DiskRequest
import com.emiryanvl.diskaccounting.service.DiskService
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DiskAccountingApplicationTests {

    @Autowired
    private lateinit var diskService: DiskService

    @Test
    fun createDiskItemTest() {
        val request = DiskRequest("Фильм 1", false)
        val response = diskService.create(request)
        assertEquals(request.title, response.title)
        assertEquals(request.isRented, response.isRented)
    }

    @Test
    fun getAllDiskItemsTest() {
        diskService.create(DiskRequest("Фильм 1", false))
        diskService.create(DiskRequest("Фильм 2", true))
        diskService.create(DiskRequest("Фильм 3", false))
        diskService.create(DiskRequest("Фильм 4", true))
        diskService.create(DiskRequest("Фильм 5", true))

        val response = diskService.getAll()
        assertTrue(response.isNotEmpty())
    }

    @Test
    fun getCurrentItemTest() {
        val createdDisk = diskService.create(DiskRequest("Фильм 1", false))
        val response = createdDisk.id?.let { diskService.get(it) }
        if (response != null) {
            assertEquals(response.isRented, false)
        }
    }

    @Test
    fun updateCurrentItemTest() {
        val createdDisk = diskService.create(DiskRequest("Фильм 1", false))
        val request = DiskRequest("Мультфильм 1", false)
        val response = createdDisk.id?.let { diskService.update(it, request) }
        if (response != null) {
            assertEquals(request.title, response.title)
            assertEquals(request.isRented, response.isRented)
        }
    }

    @Test
    fun deleteCurrentItemTest() {
        val createdDisk = diskService.create(DiskRequest("Фильм 1", false))
        var disks = diskService.getAll()
        assertTrue(disks.isNotEmpty())
        createdDisk.id?.let { diskService.delete(it) }
        disks = diskService.getAll()
        assertFalse(disks.any { it.id == createdDisk.id })
    }
}
