/*
 * Created on 29.06.2005 for PIROL
 *
 * SVN header information:
 *  $Author: javamap $
 *  $Rev: 856 $
 *  $Date: 2007-06-19 06:15:27 +0200 (Di, 19. Jun 2007) $
 *  $Id: PowerOfOperation.java 856 2007-06-19 04:15:27Z javamap $
 */
package de.fho.jump.pirol.utilities.FormulaParsing.Operations;

import com.vividsolutions.jump.feature.Feature;

import de.fho.jump.pirol.utilities.FormulaParsing.FormulaValue;

/**
 * Class to handle Math.pow() like operations. The result is a value that equals
 * <code>Math.pow(value1, value2)</code>.
 *
 * @author Ole Rahn
 * <br>
 * <br>FH Osnabr&uuml;ck - University of Applied Sciences Osnabr&uuml;ck,
 * <br>Project: PIROL (2005),
 * <br>Subproject: Daten- und Wissensmanagement
 * 
 * @version $Rev: 856 $
 * 
 */
public class PowerOfOperation extends GenericOperation {

    /**
     *@param value1
     *@param value2
     */
    public PowerOfOperation(FormulaValue value1, FormulaValue value2) {
        super(value1, value2);
    }

    /**
     *@param feature
     *@return Math.pow(value1, value2)
     */
    public double getValue(Feature feature) {
        return Math.pow(this.value1.getValue(feature), this.value2.getValue(feature));
    }
    
    
    /**
     *@inheritDoc
     */
    public String toString() {
        return "Math.pow("+ this.value1.toString() +", "+ this.value2.toString() +")";
    }
}
