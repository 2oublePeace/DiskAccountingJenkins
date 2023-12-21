package com.emiryanvl.diskaccounting

import com.emiryanvl.diskaccounting.dto.request.DiskRequest
import com.emiryanvl.diskaccounting.service.impl.DiskServiceImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class DiskAccountingApplicationTests {

    @Autowired
    private lateinit var diskService: DiskServiceImpl

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
        diskService.create(DiskRequest("Фильм 1", false))
        val response = diskService.get(1)
        assertEquals(response.isRented, false)
    }

    @Test
    fun updateCurrentItemTest() {
        diskService.create(DiskRequest("Фильм 1", false))
        val request = DiskRequest("Мультфильм 1", false)
        val response = diskService.update(1, request)
        assertEquals(request.title, response.title)
        assertEquals(request.isRented, response.isRented)
    }

    @Test
    fun deleteCurrentItemTest() {
        diskService.create(DiskRequest("Фильм 1", false))
        var disks = diskService.getAll()
        assertTrue(disks.isNotEmpty())
        diskService.delete(1)
        disks = diskService.getAll()
        assertTrue(disks.isEmpty())
    }
}
