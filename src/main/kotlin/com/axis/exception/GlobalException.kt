package axis.exception

import org.springframework.web.bind.annotation.RestControllerAdvice
import axis.exception.IDNotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler

//it help to make this class work as global 
@RestControllerAdvice
class GlobalException {
    @ExceptionHandler(value = [IDNotFoundException::class])
    fun myEmployeeIdException(exception: IDNotFoundException): ResponseEntity<Any> {
        return ResponseEntity(exception.msg, HttpStatus.NOT_FOUND)
    }
}