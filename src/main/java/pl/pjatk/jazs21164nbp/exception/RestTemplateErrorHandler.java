package pl.pjatk.jazs21164nbp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.HttpStatus.Series.CLIENT_ERROR;
import static org.springframework.http.HttpStatus.Series.SERVER_ERROR;

public class RestTemplateErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
        return (
                clientHttpResponse.getStatusCode().series() == CLIENT_ERROR
                        || clientHttpResponse.getStatusCode().series() == SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {
        if (clientHttpResponse.getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            if (clientHttpResponse.getStatusCode() == INTERNAL_SERVER_ERROR) {
                throw new BadGatewayException();
            }
        } else if (clientHttpResponse.getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            if (clientHttpResponse.getStatusCode() == NOT_FOUND) {
                throw new NotFoundException();
            }
            if (clientHttpResponse.getStatusCode() == BAD_REQUEST) {
                throw new BadRequestException();
            }
        }
    }
}
