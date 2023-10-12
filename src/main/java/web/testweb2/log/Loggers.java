
package web.testweb2.log;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mont_
 */
public class Loggers {
    private static final Logger logger = Logger.getLogger(Loggers.class.getName());
    
    
    public static void main(String[] args) {
        //Se utiliza para informar
        logger.log(Level.INFO,"Este es un mensaje de nievl INFO");
        
        //Generar mensajes de advertencia
        logger.log(Level.WARNING,"Este es un mensaje de advertencia");
        
        //Generar unmensaje de error
        logger.log(Level.SEVERE, "Este es un mensaje SEVERE o de error");
        
        try{
            dividir(10,5);
            
        }catch(ArithmeticException e){
            logger.log(Level.SEVERE, "Division invalida por cero "+e);
    }
    }
    public static double dividir (int numerador, int denominador)throws ArithmeticException{
            
        if(denominador != 0){
           double dividir = numerador/denominador;
           return dividir;
        }else
              throw new ArithmeticException("Division invada por cero");
        }
    
}
    
    

