package org.SuwonHoneyFist.day09.oop.overriding;

class SuperClass {
    void paint() {
        draw();
    }

    void draw() {
        System.out.println("Super Object");
    }
}

class SubClass extends SuperClass {
    void paint() {
        super.paint();
        this.draw(); // 수정: super.draw() -> this.draw()
    }

    void draw() {
        System.out.println("Sub Object");
    }
}

public class SampleProgram {
    public static void main(String[] args) {
        SubClass ex = new SubClass(); // 수정: SuperClass -> SubClass
        ex.paint();
    }
}
