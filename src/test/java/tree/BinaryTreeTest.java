package tree;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BinaryTree 클래스")
class BinaryTreeTest {

    @Nested
    @DisplayName("기본 생성자를 이용한 init")
    class Init_Test {
        @Test
        @DisplayName("문제없이 잘 실행됩니다.")
        void init_test() {
            BinaryTree bt = new BinaryTree();
        }
    }

    @Nested
    @DisplayName("엔진을 주입한 init")
    class Init_test2 {

        @Test
        @DisplayName("문제없이 잘 실행됩니다.")
        void init_test() {
            assertDoesNotThrow( () -> {
                BinaryTree bt = new BinaryTree(new RecursiveTraversal());
                BinaryTree b2 = new BinaryTree(new RecursiveTraversal());
            });
        }
    }
//    
//    @Nested
//    @DisplayName("트리 순회 테스트")

}