package io.github.yhugorocha.provider;

import io.github.yhugorocha.exception.MethodNotAllowedException;
import io.github.yhugorocha.exception.StandartError;
import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class MethodNotAllowedExceptionMapper implements ExceptionMapper<MethodNotAllowedException> {
    @Override
    public Response toResponse(MethodNotAllowedException e) {
        StandartError standartError = new StandartError(HttpResponseStatus.METHOD_NOT_ALLOWED.code(), Response.Status.METHOD_NOT_ALLOWED.toString(), e.getMessage(), System.currentTimeMillis());
        return Response.status(Response.Status.METHOD_NOT_ALLOWED)
                .entity(standartError)
                .build();
    }
}
