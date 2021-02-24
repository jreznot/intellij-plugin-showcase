package org.example.spring

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.codeInsight.daemon.ImplicitUsageProvider
import com.intellij.psi.*

// 1. Simple extension for framework
class SpringImplicitUsagesProvider : ImplicitUsageProvider {
    override fun isImplicitRead(element: PsiElement): Boolean = false

    override fun isImplicitWrite(element: PsiElement): Boolean {
        return element is PsiField && AnnotationUtil.isAnnotated(element, AUTOWIRE_ANNOTATIONS, 0)
    }

    override fun isImplicitUsage(element: PsiElement): Boolean {
        if (element is PsiClass) {
            return AnnotationUtil.isAnnotated(element, BEAN_ANNOTATIONS, 0)
        }
        if (element is PsiMethod) {
            return element.hasModifierProperty(PsiModifier.PUBLIC)
                    && !element.hasModifierProperty(PsiModifier.STATIC)
                    && AnnotationUtil.isAnnotated(element, CONTROLLER_METHOD_ANNOTATIONS, 0)
                    && inControllerClass(element)
        }
        return false
    }

    private fun inControllerClass(element: PsiMethod): Boolean {
        val containingClass = element.containingClass
        return containingClass != null
                && containingClass.qualifiedName != null
                && AnnotationUtil.isAnnotated(containingClass, CONTROLLER_ANNOTATION, 0)
    }
}