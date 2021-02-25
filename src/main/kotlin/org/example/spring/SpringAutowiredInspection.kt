package org.example.spring

import com.intellij.codeInsight.AnnotationUtil
import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool
import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.codeInspection.ProblemHighlightType
import com.intellij.psi.PsiField

// 3. Inspection
class SpringAutowiredInspection : AbstractBaseJavaLocalInspectionTool() {

    override fun checkField(
        field: PsiField,
        manager: InspectionManager,
        isOnTheFly: Boolean
    ): Array<ProblemDescriptor> {
        if (AnnotationUtil.isAnnotated(field, AUTOWIRED_ANNOTATION, 0)) {
            return arrayOf(
                manager.createProblemDescriptor(
                    field.nameIdentifier, "Field injection is not recommended!", isOnTheFly,
                    emptyArray(), ProblemHighlightType.WARNING
                )
            )
        }
        return ProblemDescriptor.EMPTY_ARRAY
    }
}