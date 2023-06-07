package com.yanisin.sims.view;

import com.yanisin.sims.model.bean.*;
import com.yanisin.sims.model.util.ControllerSet;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yanisin
 * @Date: 2023/6/3 19:06
 * @PackageName: com.yanisin.sims.view
 * @ClassName: ItemTree
 * @Description: //TODO
 **/
public class SidebarPane extends BorderPane {
    private ControllerSet controllerSet;
    private TreeView<String> treeView;
    private BorderPane content;
    public SidebarPane(BorderPane pane) {
        controllerSet = new ControllerSet();
        treeView = new TreeView<>();
        this.content = pane;
        initTreeView();
        this.setCenter(treeView);
    }

    private void initTreeView() {
        TreeItem<String> rootItem = new TreeItem<String>("管理对象");
        rootItem.setExpanded(true);

        treeView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            TreeItem<String> item = treeView.getSelectionModel().getSelectedItem();
            if (event.getClickCount() == 2 && item != null)
            {
                String itemName = item.getValue();
                if (itemName.equals("成员管理"))
                {
                    String farItem = item.getParent().getValue();
                    List<Student> students = controllerSet.getClasseController().getHasStudentsById(farItem);
                    content.setCenter(new StudentView(students));
                }
                else if (itemName.equals("选课管理"))
                {
                    String farItem = item.getParent().getValue();
                    List<Lesson> lessons = new ArrayList<Lesson>();
                    List<Student> students = controllerSet.getClasseController().getHasStudentsById(farItem);
                    for(Student student : students)
                        lessons.addAll(controllerSet.getStudentController().getSelectedLessonById(student.getStu_id()));
                    content.setCenter(new LessonView(lessons));
                }
                else if (itemName.equals("班级管理"))
                {
                    String farItem = item.getParent().getValue();
                    Department department = controllerSet.getDepartmentController().getDepartmentByName(farItem);
                    List<Classe> classes = controllerSet.getDepartmentController().getHasClassesById(department.getDept_id());
                    content.setCenter(new ClasseView(classes));
                }
                else if (itemName.equals("教师管理"))
                {
                    String farItem = item.getParent().getValue();
                    Department department = controllerSet.getDepartmentController().getDepartmentByName(farItem);
                    List<Teacher> teachers = controllerSet.getDepartmentController().getHasTeachersById(department.getDept_id());
                    content.setCenter(new TeacherView(teachers));
                }
                else if (itemName.equals("院系管理"))
                {
                    List<Department> departments = controllerSet.getDepartmentController().getAllDepartments();
                    content.setCenter((new DepartmentView(departments)));
                }
                else if (itemName.equals("课程管理"))
                {
                    List<Course> courses = controllerSet.getCourseController().getAllCourse();
                    content.setCenter(new CourseView(courses));
                }
                else if (itemName.equals("用户管理"))
                {
                    List<User> users = controllerSet.getUserController().gectAllUsers();
                    content.setCenter(new UserView(users));
                }
            }
        });

        TreeItem<String> depart = new TreeItem<String>("院系管理");
        List<Department> departmentList = controllerSet.getDepartmentController().getAllDepartments();
        for(Department department : departmentList) {
            // 创建某院系项
            TreeItem deptItem = new TreeItem<String>(department.toString());
            deptItem.setExpanded(true);

            // 创建该院系下的班级管理项
            TreeItem<String> classeItem = new TreeItem<String>("班级管理");
            List<Classe> classeOfDeptList = controllerSet.getDepartmentController().getHasClassesById(department.getDept_id());
            for(Classe classe : classeOfDeptList) {
                // 创建属于该部门的某个班级项
                TreeItem tmpItem = new TreeItem<String>(classe.toString());
                tmpItem.setExpanded(true);

                // 创建属于该班级的人员管理项
                TreeItem<String> personItem = new TreeItem<String>("成员管理");
                personItem.setExpanded(false);
                // 创建属于该班级的选课管理项
                TreeItem<String> lessonItem = new TreeItem<String>("选课管理");
                lessonItem.setExpanded(false);

                // 添加
                tmpItem.getChildren().addAll(personItem, lessonItem);
                classeItem.getChildren().addAll(tmpItem);
            }
            // 创建该院系下的教师管理项
            TreeItem<String> teacherItem = new TreeItem<String>("教师管理");
            teacherItem.setExpanded(false);

            // 在该院系下添加以上三项
            deptItem.getChildren().addAll(classeItem, teacherItem);
            depart.getChildren().add(deptItem);
        }
        TreeItem<String> course = new TreeItem<String>("课程管理");
        TreeItem<String> user = new TreeItem<String>("用户管理");

        rootItem.getChildren().addAll(depart, course, user);
        treeView.setRoot(rootItem);
    }
}
