package com.emiryanvl.mainservice.dto.request

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "DTO запроса для сущности Disk")
class DiskRequest (
    @Schema(description = "Название диска", example = "Принц персии")
    val title: String,
    @Schema(description = "Определяет, в прокате ли диск", example = "false")
    val isRented: Boolean = false
)