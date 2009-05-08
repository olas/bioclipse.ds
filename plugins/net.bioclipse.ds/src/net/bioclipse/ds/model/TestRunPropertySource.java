package net.bioclipse.ds.model;

import java.util.ArrayList;
import java.util.HashMap;

import net.bioclipse.core.domain.props.BasicPropertySource;

import org.eclipse.ui.views.properties.IPropertyDescriptor;
import org.eclipse.ui.views.properties.IPropertySource2;
import org.eclipse.ui.views.properties.PropertyDescriptor;
import org.eclipse.ui.views.properties.TextPropertyDescriptor;


public class TestRunPropertySource extends BasicPropertySource 
                                                implements IPropertySource2{

    protected static final String NAME = "Name";
    protected static final String HITS = "Hits";

    private Object SimplePropertiesTable[][] =
    {
            { NAME, new TextPropertyDescriptor(NAME,"Name")},
            { HITS, new TextPropertyDescriptor(HITS,"No Hits")},
    };

    public TestRunPropertySource(TestRun item) {
        super( item );

        // clean the table
        setProperties(new ArrayList<IPropertyDescriptor>());
        setValueMap(new HashMap<String, String>());


        // setup the new properties

        // the general ones first
        for (int i=0;i<SimplePropertiesTable.length;i++) {        
            // Add each property supported.
            PropertyDescriptor descriptor;
            descriptor = (PropertyDescriptor)SimplePropertiesTable[i][1];
            descriptor.setCategory("General");
            getProperties().add((IPropertyDescriptor)descriptor);
        }   

        addToValueMap(NAME,item.getTest().getName());
        if (item.hasMatches())
            addToValueMap(HITS,""+item.getMatches().size());
        else
            addToValueMap(HITS,"N/A");

    }    
    
    
    /**
     * Validate strings are non-empty or else add "N/A"
     * @param keyString
     * @param valueString
     */
    private void addToValueMap(String keyString, String valueString) {
      if (keyString==null || keyString=="") return;
      
      if (valueString==null || valueString=="")
        getValueMap().put(keyString,"N/A");
      else
        getValueMap().put(keyString,valueString);
    }

}