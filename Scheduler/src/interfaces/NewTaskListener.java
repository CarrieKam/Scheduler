package interfaces;
import java.util.EventListener;

public interface NewTaskListener extends EventListener{
			public void modeHome(boolean modeHome);
			public void setDate(String date);
			public void setTime(String time);
			public void setName(String name);
			public void setDescription(String description);
			
}
