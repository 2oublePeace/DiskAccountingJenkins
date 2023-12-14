package com.emiryanvl.diskaccounting.repository

import com.emiryanvl.diskaccounting.entity.DiskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiskRepository : JpaRepository<DiskEntity, Long>