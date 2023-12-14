package com.emiryanvl.diskaccounting.controller

import com.emiryanvl.diskaccounting.dto.request.DiskRequest
import com.emiryanvl.diskaccounting.dto.response.DiskResponse
import com.emiryanvl.diskaccounting.service.DiskService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Tag(name="Диски", description="Взаимодействие с дисками")
@RestController
@RequestMapping("/disk")
class DiskController (val diskService: DiskService) {
    @Operation(
        summary = "Получение записи диска",
        description = "Позволяет получить запись диска по его id"
    )
    @GetMapping("/{id}")
    fun getDisk(@PathVariable id: Long) : ResponseEntity<DiskResponse> {
        return ResponseEntity<DiskResponse>(diskService.get(id), HttpStatus.OK)
    }

    @Operation(
        summary = "Получение записи дисков",
        description = "Позволяет получить записи всех дисков"
    )
    @GetMapping
    fun getDisks() : ResponseEntity<List<DiskResponse>> {
        return ResponseEntity<List<DiskResponse>>(diskService.getAll(), HttpStatus.OK)
    }

    @Operation(
        summary = "Создание записи диска",
        description = "Позволяет создать запись диска"
    )
    @PostMapping
    fun createDisk(@RequestBody diskRequest: DiskRequest) : ResponseEntity<DiskResponse> {
        return ResponseEntity<DiskResponse>(diskService.create(diskRequest), HttpStatus.CREATED)
    }

    @Operation(
        summary = "Обновление записи диска",
        description = "Позволяет обновить запись диска по его id"
    )
    @PutMapping("/{id}")
    fun updateDisk(@PathVariable id: Long, @RequestBody diskRequest: DiskRequest) : ResponseEntity<DiskResponse> {
        return ResponseEntity<DiskResponse>(diskService.update(id, diskRequest), HttpStatus.OK)
    }

    @Operation(
        summary = "Удаление записи диска",
        description = "Позволяет удалить запись диска по его id"
    )
    @DeleteMapping("/{id}")
    fun deleteDisk(@PathVariable id: Long) : ResponseEntity<Unit> {
        return ResponseEntity<Unit>(diskService.delete(id), HttpStatus.OK)
    }
}