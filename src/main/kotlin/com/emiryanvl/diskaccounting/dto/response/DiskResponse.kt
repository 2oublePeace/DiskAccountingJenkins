package com.emiryanvl.diskaccounting.dto.response

import io.swagger.v3.oas.annotations.media.Schema

@Schema(description = "DTO ответа для сущности Disk")
class DiskResponse(
        @Schema(description = "Название диска", example = "Принц персии")
        val title: String,
        @Schema(description = "Определяет, в прокате ли диск", example = "false")
        val isRented: Boolean,
        @Schema(description = "Идентификатор сущности", example = "3")
        val id: Long? = null
)