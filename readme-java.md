# Review
## Java
### Snippets
```
// Common utils
// Java Map
map.putIfAbsent(K key, V value)
map.getOrDefault(Object key, V defaultValue)
// StringBuilder sb
sb.append("abc");
sb.setLength(0); // delete entire content
sb.delete(fromIndex, toIndex);
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



### Junit Tests
* Testing components
  * Declare the component class as @InjectMocks private member
```aiignore
    @InjectMocks
    private TransactionService transactionService;
```
  * Declare the dependencies as @Mock private members
```aiignore
    @Mock
    private TransactionRepository transactionRepository;
```
  * Initialize the mocks
```aiignore
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
```
  * Write the test methods
```aiignore
    @Test
    public void testGetTransactionById() {
        Transaction transaction = new Transaction();
        transaction.setId(1L);
        transaction.setAmount(1000);
        transaction.setTransactionType("credit");
        transaction.setTransactionDate(new Date());
        when(transactionRepository.findById(1L)).thenReturn(Optional.of(transaction));
        Transaction actualTransaction = transactionService.getTransactionById(1L);
        assertEquals(transaction, actualTransaction);
    }

    // Use @ExtendWith(MockitoExtension.class) to avoid using @BeforeEach
    //Use lenient to avoid strict stubbing (e.g. when a method is called with different arguments
    or not called at all when set up in beforeEach
      lenient().when(settingRepository.getUserMinAge()).thenReturn(10);
     
