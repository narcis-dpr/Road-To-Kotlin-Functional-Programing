package com.narcis.algbdatatype

typealias Callback<Data, Result, Error> = (Data, Result?, Error?) -> Unit

class Response
class Info
class ErrorInfo

fun runAsync(callback: Callback<Response, Info, ErrorInfo>) {
    // in case of success :
    callback(Response(), Info(), null)

    // in case of error :
    callback(Response(), null, ErrorInfo())
}

typealias SafeCallback<Data, Result, Error> =
        (Pair<Data, Either<Error, Result>>) -> Unit


