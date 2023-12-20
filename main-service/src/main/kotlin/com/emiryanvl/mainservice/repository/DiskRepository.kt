package com.emiryanvl.mainservice.repository

import com.emiryanvl.mainservice.entity.DiskEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DiskRepository : JpaRepository<DiskEntity, Long>