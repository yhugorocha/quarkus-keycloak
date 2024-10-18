package io.github.yhugorocha.provider;

import io.github.yhugorocha.exception.ForbiddenException;
import io.github.yhugorocha.exception.StandartError;
import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class ForbiddenExceptionMapper implements ExceptionMapper<ForbiddenException> {
    @Override
    public Response toResponse(ForbiddenException e) {
        StandartError standartError = new StandartError(HttpResponseStatus.FORBIDDEN.code(), Response.Status.FORBIDDEN.toString(), e.getMessage(), System.currentTimeMillis());
        return Response.status(Response.Status.FORBIDDEN)
                .entity(standartError)
                .build();
    }
}
