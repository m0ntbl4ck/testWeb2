
package web.testweb2.log;


import org.apache.log4j.Logger;


/**
 *
 * @author mont_
 */
public class Loggerlog4j {
    private static final Logger logger = Logger.getLogger(Loggerlog4j.class);
    
    public static void main(String[] args) {
    /*    logger.debug("Este es un mensaje de nivel DEBUG");
        logger.info("Este es un mensaje dfe nivel INFO");
        logger.warn("Este es un mensaje dfe nivel WARNING");
        logger.error("Este es un mensaje dfe nivel ERROR");
        logger.fatal("Este es un mensaje dfe nivel FATAL");*/
    
         try{
           
             System.out.println("LA DIVISION ES :"+ dividir(10,0));
        }catch(ArithmeticException e){
            logger.error("Division invalida por cero "+e);
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
