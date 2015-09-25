import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.treeptik.conf.ApplicationConfiguration;

public class Runtime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AnnotationConfigApplicationContext applicationContext = 
				new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
	}

}
