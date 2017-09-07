# simple-bdd
### Status
[![Build Status](https://api.travis-ci.org/codehackerr/simple-bdd.png)](https://api.travis-ci.org/codehackerr/simple-bdd.png)

BDD from anywhere unit/integration tests or simply any java code

# Usage:
```
    @Test
    public void string_building() {
    
        String hello = "hello";
        String world = "world";
        StringBuilder helloWorld = new StringBuilder();

        given(() -> {

            assert hello.length() != 0;
            assert world.length() != 0;

        }).when(() -> {

            helloWorld.append(hello).append(world);

        }).then(() -> {

            assertThat(helloWorld.toString(), is("helloworld"));

        });
    }

```