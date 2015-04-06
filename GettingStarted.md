# Setup #

First, you need to add the gwt-dialogs jar file to your project's build path.

## Setting your project with Eclipse (without maven) ##

  1. Right-click on the project node in the Package Explorer and select 'Build Path > Add External Archives...'.
  1. Specify the downloaded gwt-dialogs-`<`version`>`.jar

## Setting up your project with Maven ##
If you use Maven to build you project (what i personnaly recommend) you can easily set you project with gwt-dialogs by adding the following dependency to your **pom.xml**:

```
<dependency>
	<groupId>com.tinesoft</groupId>
	<artifactId>gwt-dialogs-library</artifactId>
	<version>1.0.0</version>
</dependency>
```


The dependency is published on Maven Central. So nothing more is required to have it working.

But if you want to use a snapshot (= under development) version of the library, you must add the following in the **`<`repositories`>`** section of your pom.xml:
```
<repository>
        <id>sonatype.snapshots</id>
        <name>Sonatype snapshot repository</name>
        <url>https://oss.sonatype.org/content/repositories/snapshots/</url>  
        <layout>default</layout>
</repository>
```

## Configuring your  `*`.gwt.xml Module ##

Modify <Your Application>.gwt.xml to inherit the gwt-dialogs module:
```
  <inherits name='com.tinesoft.gwt.dialogs.GWTDialogs' />
```
You will also need to download and add **gwt-dnd** (Drag Drop library). We used version 3.1.2, but it may also work with newer versions.
```
  <inherits name='com.allen_sauer.gwt.dnd.gwt-dnd'/>
```

# Using the MessageDialog #

**Simple usage:**
```
//Show a information message dialog
MessageDialog.inform("Your information message.");

//Show a warning message dialog
MessageDialog.warn("Your warning message.");

//Show an error message dialog
MessageDialog.error("Your error message.");

//Ask a question
MessageDialog.ask("Your question message.");
```


# Using the ColorDialog #

Simple usage:
```


ColorDialog.show("Pick a color.", "#ff00ff"/*default color*/, new ColorDialogEventAdapter() {

            @Override
            public void onOkButtonClicked() {
                 String pickedColor = ColorDialog.getColor();
                 //do something with the color ...
            }
        });

```

# Using the ContextMenuDialog #

### With uibinder ###
**MyView.ui.xml:**
```
<!DOCTYPE ui:UiBinder SYSTEM "http://dl.google.com/gwt/DTD/xhtml.ent">

<ui:UiBinder xmlns:ui='urn:ui:com.google.gwt.uibinder'
    xmlns:g='urn:import:com.google.gwt.user.client.ui'
    xmlns:my='urn:import:com.tinesoft.gwt.dialogs.client.menu.ui'
    ui:generateFormat='com.google.gwt.i18n.rebind.format.PropertiesFormat'
    ui:generateKeys='com.google.gwt.i18n.rebind.keygen.MD5KeyGenerator'
    ui:generateLocales='default'>

<ui:with type="com.tinesoft.gwt.dialogs.showcase.client.resources.ShowcaseResources" field="res" />


<g:FlowPanel>
  <my:ContextMenuDialogWidget triggerMode="onMouseOver">
      <my:target>
          <g:Button ui:field="overMenuButton">
              <ui:msg description="Over Menu button">Mouse over to see the context menu...</ui:msg>
          </g:Button>     
      </my:target>
      <my:menuitem><my:MenuItemWidget icon="{res.editIcon}" text="Menu item 1" ui:field="editMenuItem"/></my:menuitem>
      <my:menuitem><my:MenuItemWidget icon="{res.searchIcon}" text="Menu item 2"  ui:field="searchMenuItem"/></my:menuitem>
      <my:menuitem><my:MenuItemWidget icon="{res.deleteIcon}" text="Menu item 3"  ui:field="deleteMenuItem"/></my:menuitem>
      <my:separator/>
      <my:menuitem><my:MenuItemWidget  text="Menu item 4"/></my:menuitem>
  </my:ContextMenuDialogWidget>
</g:FlowPanel>
<ui:Uibinder>

```

#### Explanation ####

  * Define the namespace prefix for widgets used to build the menu dialog. Here i have chosen **my** as prefix, and the package containing the widgets is **com.tinesoft.gwt.dialogs.client.menu.ui**. So the namespace definition will be:
```
xmlns:my='urn:import:com.tinesoft.gwt.dialogs.client.menu.ui'
```
  * Add the context menu dialog widget
    * define how the menu dialog appears by setting the `triggerMode`
    * define to which widget will the menu be associated (the **target**):
```
<my:target>
    <g:Button ui:field="overMenuButton">
        <ui:msg description="Over Menu button">Mouse over to see the context menu...</ui:msg>
    </g:Button>     
</my:target>
```
    * add menu items: Each menu item can have an icon and a text.


**MyView.java:**
```
...
@UiField
MenuItemWidget editMenuItem;
...

//Event Handlers
@UiHandler("editMenuItem")
void onEditMenuItemClicked(MenuItemClickEvent event)
{
     //the menu item has been clicked, do something...
}

```