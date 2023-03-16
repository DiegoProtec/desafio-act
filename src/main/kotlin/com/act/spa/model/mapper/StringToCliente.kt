package com.act.spa.model.mapper

import org.mapstruct.Qualifier
import kotlin.annotation.AnnotationRetention.*
import kotlin.annotation.AnnotationTarget.*

@Qualifier
@Target(CLASS)
@Retention(RUNTIME)
annotation class StringToObject
@Qualifier
@Target(FUNCTION)
@Retention(RUNTIME)
annotation class StringToCliente
