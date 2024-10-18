package io.github.yhugorocha.provider;

import io.github.yhugorocha.exception.StandartError;
import io.github.yhugorocha.exception.UnauthorizedException;
import io.netty.handler.codec.http.HttpResponseStatus;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class UnathorizedExceptionMapper implements ExceptionMapper<UnauthorizedException> {
    @Override
    public Response toResponse(UnauthorizedException e) {
        StandartError standartError = new StandartError(HttpResponseStatus.UNAUTHORIZED.code(), Response.Status.UNAUTHORIZED.toString(), e.getMessage(), System.currentTimeMillis());
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(standartError)
                .build();
    }
}
