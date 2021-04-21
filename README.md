# JAVA_Study

- Java 언어 공부 레퍼지토리
- 개발환경 : Java JDK 1.7, Eclipse Kepler



## Eclipse Git 연동

- JDK 1.7 사용시 변경사항
  - window - preferences -> Team -> git -> configuration -> Add Entry.. 클릭 -> Key = http.sslVerify, Vlaue = false 추가
  - 설치 경로 이동 -> eclipse.ini(톱니바퀴 모양 아이콘) -> 맨 뒤에 '-Dhttps.protocols=TLSv1.1,TLSv1.2' 추가
- 레퍼지토리 생성 후 code의 http 주소 복사
- Window -> ShowView -> other -> git -> git repository -> URL 붙여넣기 & 계정 & 패스워드 입력
- 프로젝트 생성 후 우클릭 -> team -> share project -> git -> 연동된 레퍼지토리 주소로 설정
- Add to index -> commit -> push



## Java Programming Basic

- [Variable(변수)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/a_variable/Variable.java)
- [Arithmetic Operator(산술연산자)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/b_operator/ArithmeticOperator.java)
- [Comparing Operator(비교연산자)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/b_operator/ComparingOperator.java)
- [Logical Operator(논리연산자)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/b_operator/LogicalOperator.java)
- [Etc Operator(그 외 연산자)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/b_operator/Etc.java)
- [Conditional Statement(조건문)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/c_statement/ConditionalStatement.java)
- [Repetitive Statement(반복문)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/c_statement/RepetitiveStatement.java)
- [Array(배열)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/d_array/Array.java)
- [Sort(정렬)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/d_array/Sort.java)
- [Multi Dimensional Array(다차원 배열)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/d_array/MultiDimensionalArray.java)
- [User Defined DataType(사용자 정의 데이터 타입-클래스)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/e_oop/UserDefinedDataType.java)
- [String Class](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/e_oop/StringClass.java)


## 객체 지향 프로그래밍
- [Object Oriented Programming(객체 지향 프로그래밍)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/e_oop/OOP.java)
- [Method(메서드)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/e_oop/SampleClass.java)
- [Static](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/e_oop/Static.java)
- [JVM](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/e_oop/JVM.java)
- [Constructor(생성자)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/e_oop/VariableInit.java)
- [Extends(상속)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/g_oop2/SampleParent.java)
- [Access Modifier(접근제어자)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/g_oop2/AccessModifier.java)
- [abstract(추상메서드 & 추상클래스)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/g_oop2/SampleAbstractParent.java)
- [interface(인터페이스)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/g_oop2/SampleInterface.java)
- [Exception(예외처리)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/h_exception/ExceptionHanding.java)
- [Regular Expression(정규 표현식)](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/i_regex/RegularExpression.java)


## Collection Framwork & JDBC
- [ArrayList](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/j_collection/ArrayListClass.java)
- [Vector](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/collection%20test/src/kr/or/ddit/basic/VectorTest.java)
- [HashMap01](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/j_collection/HashMapClass.java)
- [HashMap02](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/collection%20test/src/kr/or/ddit/basic/MapTest01.java)
- [JDBC](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/k_jdbc/JDBC.java)
- [JDBC Singleton](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/JavaProgramming/src/k_jdbc/JDBCUtil.java)
- [Stack&Queue](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/collection%20test/src/kr/or/ddit/basic/StackQueueTest.java)
- [Set](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/collection%20test/src/kr/or/ddit/basic/SetTest.java)
- [Properties](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/collection%20test/src/kr/or/ddit/basic/PropertiesTest.java)
- [Equals & HashCode 재정의](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/collection%20test/src/kr/or/ddit/basic/EqualsHashCodeTest.java)


## Generic
- [Varargs](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/genericTest/src/kr/or/ddit/basic/args/ArgsTest.java)
- [Generic](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/genericTest/src/kr/or/ddit/basic/generic/GenericTest.java)
- [Enum](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/genericTest/src/kr/or/ddit/basic/enumtest/EnumTest.java)

## Thread
- [Thread](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadTest02.java)
- [DaemonThread](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadTest08.java)
- [ThreadStatement](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadTest09.java)
- [Yield](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadTest10.java)
- [Interrupte](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadTest11.java)
  - [Horse Racing](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadHorse.java)
- [synchronization-Synchronized](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadTest16.java)
- [synchronization-Lock](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadTest17.java)
- [Collection synchronization](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadTest18.java)
- [wait & notify](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/threadTest/src/kr/or/ddit/basic/ThreadTest19.java)


## File IO
- [File Object](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/javaIoTest/src/kr/or/ddit/basic/FileTest01.java)
- [File Info](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/javaIoTest/src/kr/or/ddit/basic/FileTest03.java)
- [ByteStream](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/javaIoTest/src/kr/or/ddit/basic/ByteArrayIOTest02.java)
- [File Input](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/javaIoTest/src/kr/or/ddit/basic/FileIOTest01.java)
- [File Output](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/javaIoTest/src/kr/or/ddit/basic/FileIOTest02.java)
- [File Reader Encoding](https://github.com/HYEONSEONG-KIM/JAVA_Study/blob/main/javaIoTest/src/kr/or/ddit/basic/FileIOTest05.java)
