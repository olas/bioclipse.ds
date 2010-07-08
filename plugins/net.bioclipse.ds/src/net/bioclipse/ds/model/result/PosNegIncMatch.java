package net.bioclipse.ds.model.result;


import java.util.Map;
import org.openscience.cdk.renderer.generators.IGeneratorParameter;

/**
 * 
 * @author ola
 */
public class PosNegIncMatch extends AtomResultMatch{
	
    
    public PosNegIncMatch(String name, int resultStatus) {
		super(name, resultStatus);
	}

	@Override
	public Class<? extends IGeneratorParameter<Boolean>> getGeneratorVisibility() {
    	return (Class<? extends IGeneratorParameter<Boolean>>)PosNegIncColorGenerator.Visibility.class;
    }

    @Override
    public Class<? extends IGeneratorParameter<Map<Integer, Integer>>> getGeneratorAtomMap() {
    	return (Class<? extends IGeneratorParameter<Map<Integer, Integer>>>)PosNegIncColorGenerator.AtomMap.class;
    }
}