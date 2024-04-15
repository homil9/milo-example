## 개요

eclipse milo sdk를 사용한 example


## 환경설정

1. Java version: openjdk 17
2. IDE: IntelliJ IDEA
3. OPC UA 관련: KepserverEX6, UAExpert


## 예제 설명

    1. ExampleServer
        1) OPC UA 서버 실행 'Run ExampleServer.main()'  
        2) 실행 후 UAExpert에서 Server(ex: opc.tcp://localhost:12686/milo)를 추가.
        3) UAExpert에서 ExampleNamespace.java에 있는 Ojbect들과 그 값들을 확인할 수 있음.

    2. BrowseExample
        1) KepserverEX6 실행 또는 ExampleServer.main()을 실행하여 서버를 띄워놓기
        2) ClientExample.java 에서 endpoint url 1)에 맞춰 입력.
        3) 'Run BrowseExample.main()'
        4) console에서 ExampleNamespace.java에 있는 Ojbect들의 이름 또는 KepserverEX6에서 추가한 channel, Device, tag 이름이 출력되는 것을 확인할 수 있음.
    
    3. ReadExample, ReadNodeExample
        1) KepserverEX6 실행 또는 ExampleServer.main()을 실행하여 서버를 띄워놓기
        2) ClientExample.java 에서 endpoint url 1)에 맞춰 입력.
        3) 'Run ReadExample.main()' 또는 'Run ReadNodeExample.main()'
        4) console에서 Server 상태 관련 정보를 읽어 출력하는 것을 확인할 수 있음.

    4. ReadWriteNodeExample, ReadWriteCustomDataTypeNodeExample
        1) KepserverEX6 실행 또는 ExampleServer.main()을 실행하여 서버를 띄워놓기
        2) ClientExample.java 에서 endpoint url 1)에 맞춰 입력.
        3) read하고 write할 Node의 namespaceIndex, identifier값을 UAExpert에서 확인하여 ReadWriteNodeExample.java 또는 ReadWriteCustomDataTypeNodeExample.java를 수정 
        4) 'Run ReadWriteNodeExample.main()' 또는 'Run ReadWriteCustomDataTypeNodeExample.main()'
        5) console에서 3)의 노드의 값을 읽어 출력하고 변경하여 변경된 값을 출력하는 것을 확인할 수 있음. 

    5. SubscriptionExample
        1) KepserverEX6 실행 또는 ExampleServer.main()을 실행하여 서버를 띄워놓기
        2) ClientExample.java 에서 endpoint url 1)에 맞춰 입력.
        3) 'Run SubscriptionExample.main()'
        4) console에서 client가 일정시간마다 특정 Node의 값을 읽어서 출력하는 것을 확인할 수 있음.
