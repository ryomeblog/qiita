// �R���X�g���N�^���ł̃C���X�^���X����
public class Test1 {
    // main���\�b�h
    public static void main(String[] args) {
        // �C���X�^���X(�I�u�W�F�N�g)�𐶐�(�R���X�g���N�^�Ăяo��)
        new Hello1();
    }
}

// �R���X�g���N�^�̃e�X�g�N���X
class Hello1 {
  // �R���X�g���N�^
  Hello1() {
      // �C���X�^���X(�I�u�W�F�N�g)�𐶐�
      InstanceHello ih = new InstanceHello();
      // �C���X�^���X�̃��\�b�h�̌ďo��
      ih.showHello();
  }
}

// �C���X�^���X�̃e�X�g�N���X
class InstanceHello {
  // Hello�\�����\�b�h
  void showHello(){
      System.out.print("Hello");
  }
}