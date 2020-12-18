package tree;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("BinaryTree 클래스")
class BinaryTreeTest {

    @Nested
    @DisplayName("기본적인 클래스의 테스트를 합니다.")
    class Init_Test {
        @Test
        @DisplayName("기본 생성자로 문제없이 잘 실행됩니다.")
        void init_test() {
            BinaryTree bt = new BinaryTree();
        }

        @Test
        @DisplayName("엔진을 주입해도 문제없이 잘 실행됩니다.")
        void init_test2() {
            assertDoesNotThrow( () -> {
                BinaryTree bt = new BinaryTree(new RecursiveTraversal());
                BinaryTree bt2 = new BinaryTree(new IterativeTraversal());
                bt.setEngine(new IterativeTraversal());
                bt2.setEngine(new RecursiveTraversal());
            });
        }
    }

    @Nested
    @DisplayName("DFS의 동작 테스트를 합니다.")
    class DFS_Test {

        BinaryTree bt;
        Node A;
        Node B;
        Node C;
        Node D;
        Node E;
        Node F;
        Node G;

        @BeforeEach
        void prepare() {
            bt = new BinaryTree();
            A = new Node(1);
            B = new Node(2);
            C = new Node(3);
            D = new Node(4);
            E = new Node(5);
            F = new Node(6);
            G = new Node(7);

            bt.root = A;
            A.left = B;
            A.right = C;
            B.left = D;
            C.left = E;
            C.right = F;
            F.right = G;

        }

        @Nested
        @DisplayName("Iterative 모드에")
        class Iterative_test {

            @BeforeEach
            void prepare_iterative() {
                bt.setEngine(new IterativeTraversal());
            }


            @Test
            @DisplayName("PREORDER의 결과는 정확합니다.")
            void dfs_preorder() {
                bt.setMode(TraversalMode.PRE_ORDER);
                assertEquals("1 2 4 3 5 6 7 ", bt.dfs());
            }

            @Test
            @DisplayName("INORDER의 결과는 정확합니다.")
            void dfs_inorder() {
                bt.setMode(TraversalMode.IN_ORDER);
                assertEquals("4 2 1 5 3 6 7 ", bt.dfs());
            }

            @Test
            @DisplayName("POSTORDER의 결과는 정확합니다.")
            void dfs_postorder() {
                bt.setMode(TraversalMode.POST_ORDER);
                assertEquals("4 2 5 7 6 3 1 ", bt.dfs());
            }

        }


        @Nested
        @DisplayName("Recursive 모드에")
        class Recursive_test {

            @BeforeEach
            void prepare_iterative() {
                bt.setEngine(new RecursiveTraversal());
            }

            @Test
            @DisplayName("PREORDER의 결과는 정확합니다.")
            void dfs_preorder() {
                bt.setMode(TraversalMode.PRE_ORDER);
                assertEquals("1 2 4 3 5 6 7 ", bt.dfs());
            }

            @Test
            @DisplayName("INORDER의 결과는 정확합니다.")
            void dfs_inorder() {
                bt.setMode(TraversalMode.IN_ORDER);
                assertEquals("4 2 1 5 3 6 7 ", bt.dfs());
            }

            @Test
            @DisplayName("POSTORDER의 결과는 정확합니다.")
            void dfs_postorder() {
                bt.setMode(TraversalMode.POST_ORDER);
                assertEquals("4 2 5 7 6 3 1 ", bt.dfs());
            }


        }

        @Nested
        @DisplayName("DFS Iterator 테스트")
        class Iterator_test {

            BinaryTree bt;
            Node A;
            Node B;
            Node C;
            Node D;
            Node E;
            Node F;
            Node G;

            @BeforeEach
            void prepare() {
                bt = new BinaryTree();
                A = new Node(1);
                B = new Node(2);
                C = new Node(3);
                bt.root = A;
                A.left = B;
                A.right = C;
            }

            @Test
            @DisplayName("Iterator를 정확하게 가져올 수 있습니다.")
            void iterator() {
                bt.setMode(TraversalMode.IN_ORDER);
                Integer[] arr = new Integer[3];
                var it =  bt.iterator();
                int index = 0;
                while(it.hasNext()) {
                    arr[index++] = it.next();
                }
                assertArrayEquals(arr, new Integer[]{2, 1, 3});
            }

            @Test
            @DisplayName("ForEach가 잘 동작 합니다.")
            void for_each_test() {
                bt.setMode(TraversalMode.IN_ORDER);
                Integer[] arr = new Integer[3];
                int index = 0;
                for(Integer val : bt) {
                    arr[index++] = val;
                }
                assertArrayEquals(arr, new Integer[]{2, 1, 3});
            }
        }

    }


    @Nested
    @DisplayName("DFS의 에러/엣지 케이스 테스트를 합니다.")
    class DFS_Error {

        @Test
        @DisplayName("만약, root가 NULL이 들어온경우 NOSUCHELEMENT 에러를 던집니다.")
        void dfs_error() {
            BinaryTree bt = new BinaryTree();
            bt.setMode(TraversalMode.POST_ORDER);
            assertThrows(NoSuchElementException.class, () -> { bt.dfs(); });
        }

        @Test
        @DisplayName("만약, 노드가 한개인 경우에도 정상적으로 동작 합니다.")
        void dfs_single_element() {
            BinaryTree bt = new BinaryTree();
            Node A = new Node(1);
            bt.root = A;
            bt.setMode(TraversalMode.POST_ORDER);
            assertEquals(bt.dfs(), "1 ");
        }

        @Test
        @DisplayName("만약, root가 NULL인데 Iterator를 호출할경우 next는 hasNext는 false, next는 null이어야 합니다.")
        void dfs_iterator_error() {
            BinaryTree bt = new BinaryTree();
            bt.setMode(TraversalMode.POST_ORDER);
            assertFalse(bt.iterator().hasNext());
            assertNull(bt.iterator().next());

        }

        @Test
        @DisplayName("만약, root가 NULL인데 forEach 호출할경우 forloop을 거치지 말아야 합니다.")
        void dfs_for_each_error() {
            BinaryTree bt = new BinaryTree();
            for(Integer val: bt) {
                fail("need to ignore the for loop.");
            };
        }
    }


    @Nested
    @DisplayName("BFS의 동작 테스트합니다.")
    class BFS_Test {

        BinaryTree bt;
        Node A;
        Node B;
        Node C;
        Node D;
        Node E;
        Node F;
        Node G;

        @BeforeEach
        void prepare() {
            bt = new BinaryTree();
            A = new Node(1);
            B = new Node(2);
            C = new Node(3);
            D = new Node(4);
            E = new Node(5);
            F = new Node(6);
            G = new Node(7);

            bt.root = A;
            A.left = B;
            A.right = C;
            B.left = D;
            C.left = E;
            C.right = F;
            F.right = G;

        }

        @Test
        @DisplayName("기본 동작이 잘 됩니다.")
        void bfs_test() {
            assertEquals(bt.bfs(), "1 2 3 4 5 6 7 ");
        }

    }


    @Nested
    @DisplayName("BFS의 에러/엣지 케이스 테스트를 합니다.")
    class BFS_Error_Test {


        @Test
        @DisplayName("만약, root가 NULL이 들어온경우 NOSUCHELEMENT 에러를 던집니다.")
        void dfs_error() {
            BinaryTree bt = new BinaryTree();
            bt.setMode(TraversalMode.POST_ORDER);
            assertThrows(NoSuchElementException.class, () -> { bt.bfs(); });
        }

        @Test
        @DisplayName("만약, 노드가 한개인 경우에도 정상적으로 동작 합니다..")
        void dfs_single_element() {
            BinaryTree bt = new BinaryTree();
            Node A = new Node(1);
            bt.root = A;
            bt.setMode(TraversalMode.POST_ORDER);
            assertEquals(bt.bfs(), "1 ");
        }

    }

}