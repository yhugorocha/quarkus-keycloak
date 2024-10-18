package io.github.yhugorocha.provider;

import io.github.yhugorocha.exception.BadRequestException;
import io.github.yhugorocha.exception.StandartError;
import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    @Override
    public Response toResponse(BadRequestException e) {
        StandartError standartError = new StandartError(HttpResponseStatus.BAD_REQUEST.code(), Response.Status.BAD_REQUEST.toString(), e.getMessage(), System.currentTimeMillis());
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(standartError)
                .build();
    }
}
