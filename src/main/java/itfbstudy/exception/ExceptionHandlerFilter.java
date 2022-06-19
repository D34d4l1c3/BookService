package itfbstudy.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Log4j2
public class ExceptionHandlerFilter extends OncePerRequestFilter {
    private Response errorResponse = new Response();
    IResponse cResp;
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (Exception e) {
            Throwable cause = e.getCause();
            if(cause != null && IResponse.class.isAssignableFrom(cause.getClass())){
                cResp = (IResponse)e.getCause();
                errorResponse = new Response(cResp.getMessage(),cResp.getCode());
                response.setStatus(errorResponse.getCode());
                response.getWriter().write(convertObjectToJson(errorResponse));
            } else {
                errorResponse = new Response(e.getMessage(),500);
                response.setStatus(errorResponse.getCode());
                response.getWriter().write(convertObjectToJson(errorResponse));
            }
        }
    }
    public String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }

        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }

}