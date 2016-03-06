javac -cp "jars/*" step_definitions/CheckoutSteps.java implementation/Checkout.java
rem java -cp "jars/*;." cucumber.api.cli.Main -p pretty --snippets camelcase -g step_definitions features

java -cp "jars/*;." cucumber.api.cli.Main -p pretty --snippets camelcase -g step_definitions features