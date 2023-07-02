package gregica.api.event;

import net.minecraftforge.fml.common.eventhandler.Cancelable;
import net.minecraftforge.fml.common.eventhandler.Event;

import java.util.ArrayList;

@Cancelable
public class SearchMaterialsClassEvent extends Event {
    private final ArrayList<Class<?>> classList;
    
    public SearchMaterialsClassEvent(ArrayList<Class<?>> classList) {
        this.classList = classList;
    }
    
    public ArrayList<Class<?>> getClassList() {
        return classList;
    }
}
