# Review
## Java
### Snippets
```
// Java Map
map.putIfAbsent(K key, V value)
map.getOrDefault(Object key, V defaultValue)
```
```
// StringBuilder sb
sb.append("abc");
sb.setLength(0); // delete entire content
sb.delete(fromIndex, toIndex); 
```
```
// Stream
List number = Arrays.asList(2,3,4,5);
List square = number.stream().map(x->x*x).collect(Collectors.toList());
// Stream map to different object
List<String> names = persons.stream().map(p -> p.getName()).collect(Collectors.toList());
//Grouping all persons by department
Map<Department, List<Person>> map = persons.stream().collect(groupingBy(Person::department));
// Count persons by department
Map<Department, Long> map = persons.stream()
    .collect(groupingBy(Person::department, counting()));
```


