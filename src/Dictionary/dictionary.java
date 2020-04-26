package Dictionary;

public class dictionary {
    private class tree{ //Будем хранить слова в двоичном дереве поиска
        String word; //слово ключ
        int count;  // кол-во слов - значение
        tree right;
        tree left;
        tree(String str, int val){
            word = str;
            right = null;
            left = null;
            count = val;
        }
    }


        public dictionary(){
            dict = null;
            countWords = 0;
        }
        public int getCount(){ //вернуть кол-во лсов в словаре
            return countWords;
        }
        public void add(String str){ //добавить слово в словарь
            addEl(str);
        }
        public void print(){ //напечатать все слова по алфавиту с заглавной буквы каждое слово
            viewWord(dict);
        }
        private void viewWord(tree d){ //выводим слова по алфавиту (отсортированном виде), симметричный обход по дереву
            if (d!=null){
                viewWord(d.left); //сначала обходим все левые поддеревья
                for (int i =0;i<d.count;i++){
                    System.out.print(d.word.substring(0,1).toUpperCase() + d.word.substring(1,d.word.length())); //затем вершину выводим все слова
                    System.out.print(" ");
                }
                viewWord(d.right); //затем все правые поддеревья
            }
        }
        public int Search(String str){
            return search(dict, str);
        }
        private int search(tree d, String str){ //рекурсивно ищем элемент
            if (d==null){
                return 0; //элемент отсутствует возвращаем 0
            }else{
                if (str.compareTo(d.word)==0){ //элемент найден
                    return d.count;
                }else{ //если значение больше ключа корня идем в правое поддерево иначе в левое
                    if (str.toUpperCase().compareTo(d.word.toUpperCase()) > 0){ //для корректного сравнения и расположения слов в алфавитном порядке сравниваем их в одном регистре
                        return search(d.right,str);
                    }else{
                        return search(d.left,str);
                    }
                }
            }
        }

        private void addEl(String str){ //добавляем элемент в двоичное дерево поиска
            if (dict == null){
                dict = new tree(str,1); //создаем дерево если словарь был пустым
                countWords++;
            }else{
                boolean find = false;
                tree current = dict;
                while(!find) {
                    if (str.compareTo(current.word) == 0) { //если такое слово уже есть увеличиваем его кол-во
                        current.count += 1;
                        countWords++;
                        find = true;
                    } else {
                        if (str.toUpperCase().compareTo(current.word.toUpperCase()) > 0){ //если слово "больше" значения ключа в корне
                            //для корректного сравнения и расположения слов в алфавитном порядке сравниваем их в одном регистре
                            if (current.right!=null){ //если существует правое поддерево идем дальше в него
                                current = current.right;
                            }else{ //иначе добавляем слово в правое поддерево
                                current.right = new tree(str,1);
                                countWords++;
                                find = true;
                            }
                        }else{ //если меньше
                            if (current.left!=null){ //аналогично с левым поддеревом
                                current = current.left;
                            }else{
                                current.left = new tree(str,1);
                                countWords++;
                                find = true;
                            }
                        }
                    }
                }
            }
        }
        private tree dict;
        private int countWords;
}
