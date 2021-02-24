package org.example.spring

/* Spring Framework Definitions */

const val AUTOWIRED_ANNOTATION = "org.springframework.beans.factory.annotation.Autowired"
const val VALUE_ANNOTATION = "org.springframework.beans.factory.annotation.Value"

const val COMPONENT_ANNOTATION = "org.springframework.stereotype.Component"
const val CONTROLLER_ANNOTATION = "org.springframework.stereotype.Controller"

const val MODEL_ATTRIBUTE_ANNOTATION = "org.springframework.web.bind.annotation.ModelAttribute"
const val INIT_BINDER_ANNOTATION = "org.springframework.web.bind.annotation.InitBinder"
const val GET_MAPPING_ANNOTATION = "org.springframework.web.bind.annotation.GetMapping"
const val POST_MAPPING_ANNOTATION = "org.springframework.web.bind.annotation.PostMapping"

val BEAN_ANNOTATIONS = listOf(COMPONENT_ANNOTATION, CONTROLLER_ANNOTATION)
val AUTOWIRE_ANNOTATIONS = listOf(AUTOWIRED_ANNOTATION, VALUE_ANNOTATION)
val CONTROLLER_METHOD_ANNOTATIONS = listOf(
    MODEL_ATTRIBUTE_ANNOTATION, INIT_BINDER_ANNOTATION,
    GET_MAPPING_ANNOTATION, POST_MAPPING_ANNOTATION
)
