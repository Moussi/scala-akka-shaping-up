package basics.recursivity

/**
  * Created by moussi on 15/07/18.
  */
object ParenthesesBalancing {

    def balance(chars: List[Char]): Boolean = {
        def countParentheses(chars: List[Char], openedParentheses: Int): Boolean = {
            if (chars.isEmpty) {
                openedParentheses == 0
            } else {
                val head = chars.head
                val n =
                    if (head == '(') openedParentheses + 1
                    else if (head == ')') openedParentheses - 1
                    else openedParentheses
                if (n >= 0) countParentheses(chars.tail, n)
                else false
            }
        }

        countParentheses(chars, 0)
    }

}
