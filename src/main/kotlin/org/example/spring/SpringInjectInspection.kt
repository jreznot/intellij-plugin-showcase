package org.example.spring

import com.intellij.codeInspection.AbstractBaseJavaLocalInspectionTool
import com.intellij.codeInspection.InspectionManager
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.psi.PsiField

// 3. Inspection
class SpringInjectInspection : AbstractBaseJavaLocalInspectionTool() {

    override fun checkField(
        field: PsiField,
        manager: InspectionManager,
        isOnTheFly: Boolean
    ): Array<ProblemDescriptor> {
        // todo annotated as @Inject or @Autowired

        return super.checkField(field, manager, isOnTheFly)
    }
}