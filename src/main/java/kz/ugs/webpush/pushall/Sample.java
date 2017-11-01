package kz.ugs.webpush.pushall;

import java.util.HashMap;

public class Sample {
	public Sample ()	{
		
		//final String SERVER_KEY = args[0];
		//final String SERVER_KEY = "AAAAUtrkFNY:APA91bF2gFUIjsQXndZoersAA-d6tRjJtXOFeSp1_Z0vY5SOhlbf7Kd9FMahdw5wH2q5Ht36gb30PmA4fc1kUVm6TcUXSbPvQ6S3AjHds9fOhM-5yeZ9O5TUN-ubHamJJ7YPjt7qheCe";
		final String SERVER_KEY = "AIzaSyCNIZnXh9B8T44pNdJI43J7zZ5UhGR0rDw";

		Pushraven.setKey(SERVER_KEY);

		// create Notification object
		Notification raven = new Notification();


		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("Hello", "World!");
		data.put("Marco", "Polo");
		data.put("Foo", "Bar");

		// build raven message using the builder pattern
		raven.to("news")
			.collapse_key("a_collapse_key")
			.priority(1)
			.delay_while_idle(true)
			.time_to_live(100)
			.restricted_package_name("com.package.name")
			.dry_run(true)
			.data(data)
			.title("Testing")
			.body("Hello World!")
			.color("#ff0000");

		// push the raven message
		FcmResponse response = Pushraven.push(raven);

		// alternatively set static notification first.
		Pushraven.setNotification(raven);
		response = Pushraven.push();

		// prints response code and message
		System.out.println(response);
	}
}
