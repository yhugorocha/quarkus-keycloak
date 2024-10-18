package io.github.yhugorocha.provider;

import io.github.yhugorocha.exception.NotFoundException;
import io.github.yhugorocha.exception.StandartError;
import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException e) {
        StandartError standartError = new StandartError(HttpResponseStatus.NOT_FOUND.code(), Response.Status.NOT_FOUND.toString(), e.getMessage(), System.currentTimeMillis());
        return Response.status(Response.Status.NOT_FOUND)
                .entity(standartError)
                .build();
    }
}
