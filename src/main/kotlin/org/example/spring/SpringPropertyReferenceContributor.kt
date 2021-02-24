package org.example.spring

import com.intellij.openapi.util.TextRange
import com.intellij.patterns.PatternCondition
import com.intellij.patterns.PsiJavaElementPattern
import com.intellij.patterns.PsiJavaPatterns.psiLiteral
import com.intellij.psi.*
import com.intellij.util.ProcessingContext
import com.intellij.util.SmartList
import com.intellij.util.text.PlaceholderTextRanges
import gnu.trove.THashMap
import org.example.spring.properties.PlaceholderInfo
import org.example.spring.properties.PlaceholderPropertyReference

// 2. contribute references
class SpringPropertyReferenceContributor : PsiReferenceContributor() {
    override fun registerReferenceProviders(registrar: PsiReferenceRegistrar) {
        registrar.registerReferenceProvider(psiLanguageInjectionHost().annotationParam(VALUE_ANNOTATION),
            object : PsiReferenceProvider() {
                override fun getReferencesByElement(
                    element: PsiElement,
                    context: ProcessingContext
                ): Array<PsiReference> {
                    return createPlaceholderPropertiesReferences(element as PsiLanguageInjectionHost)
                }
            })
    }

    private fun createPlaceholderPropertiesReferences(host: PsiLanguageInjectionHost): Array<PsiReference> {
        return createPlaceholderPropertiesReferences(getTextRanges(host), host)
    }

    private fun createPlaceholderPropertiesReferences(
        textRanges: Map<TextRange, PlaceholderInfo>,
        valueElement: PsiElement?
    ): Array<PsiReference> {
        if (valueElement == null || textRanges.isEmpty()) return PsiReference.EMPTY_ARRAY

        val references = SmartList<PsiReference>()

        for ((textRange, info) in textRanges) {
            references.add(PlaceholderPropertyReference.create(valueElement, textRange, info))
        }
        return references.toTypedArray()
    }

    private fun getTextRanges(element: PsiElement): Map<TextRange, PlaceholderInfo> {
        val textRanges = THashMap<TextRange, PlaceholderInfo>()
        val text = element.text

        val ranges = PlaceholderTextRanges.getPlaceholderRanges(text, "\${", "}")
        for (textRange in ranges) {
            val placeholderText = textRange.substring(text)
            textRanges[textRange] = PlaceholderInfo(placeholderText)
        }
        return textRanges
    }

    private fun psiLanguageInjectionHost(): PsiJavaElementPattern.Capture<PsiLiteral> {
        return psiLiteral().with(object : PatternCondition<PsiLiteral>("injection host") {
            override fun accepts(t: PsiLiteral, context: ProcessingContext?): Boolean {
                return t is PsiLanguageInjectionHost
            }
        })
    }
}