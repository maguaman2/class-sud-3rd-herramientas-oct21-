package com.example.demo.model

import javax.persistence.*
@Entity
@Table(name = "workout")
class Workout {
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id: Long? = null
        var description: String? = null
}