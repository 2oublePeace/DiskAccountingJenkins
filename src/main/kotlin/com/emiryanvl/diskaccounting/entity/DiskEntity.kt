package com.emiryanvl.diskaccounting.entity

import jakarta.persistence.*

@Entity
@Table(name = "_disk")
class DiskEntity (
    var title: String,
    @Column(name = "is_rented")
    var isRented: Boolean,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
)