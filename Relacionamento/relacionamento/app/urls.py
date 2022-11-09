from django.urls import re_path
from .views import *

urlpatterns = [
    re_path(r'^marca/marca_form/', cadastrar_marca, name="cadastrar_marca"),
    re_path(r'^marca/marca_list/', listar_marca, name="listar_marca"),
    re_path(r'^marca/marca_remove/(?P<pk>[0-9]+)', marca_remove, name='marca_remove'),
    re_path(r'^marca/marca_edit/(?P<pk>[0-9]+)', marca_edit, name='marca_edit')
]