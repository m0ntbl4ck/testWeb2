package web.testweb2.jaxws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author mont_
 */
@WebService(name="operaciones")
public class Operaciones {
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "sumar")
    public String sumar(@WebParam(name = "numero1") double numero1,@WebParam(name = "numero2") double numero2 ) {
        return Double.toString(numero1+numero2);
    }
    
    @WebMethod(operationName = "restar")
    public String restar(@WebParam(name = "numero1") double numero1,@WebParam(name = "numero2") double numero2 ) {
        return Double.toString(numero1 -numero2);
    }
    
    @WebMethod(operationName = "multiplicacion")
    public String multiplicar(@WebParam(name = "numero1") double numero1,@WebParam(name = "numero2") double numero2 ) {
        return Double.toString(numero1*numero2);
    }
    
}
