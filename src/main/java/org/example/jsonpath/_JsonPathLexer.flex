package org.example.jsonpath.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.example.jsonpath.psi.JsonPathTypes;
import com.intellij.psi.TokenType;
%%

%{
  public _JsonPathLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _JsonPathLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

IDENTIFIER=([:letter:]|[_])([:letter:]|[_\-0-9])*
NUMBER_LITERAL=0|[1-9][0-9]*

%%

<YYINITIAL> {
  "$"                                  { return JsonPathTypes.ROOT_CONTEXT; }
  "@"                                  { return JsonPathTypes.EVAL_CONTEXT; }
  "."                                  { return JsonPathTypes.DOT; }
  ".."                                 { return JsonPathTypes.RECURSIVE_DESCENT; }
  "["                                  { return JsonPathTypes.LBRACKET; }
  "]"                                  { return JsonPathTypes.RBRACKET; }
  "*"                                  { return JsonPathTypes.WILDCARD; }
  ","                                  { return JsonPathTypes.COMMA; }
  {IDENTIFIER}                         { return JsonPathTypes.IDENTIFIER; }
  {NUMBER_LITERAL}                     { return JsonPathTypes.NUMBER; }
}

[^] {
    return TokenType.BAD_CHARACTER;
}