from django.urls import re_path
from .views import *

urlpatterns = [
    re_path(r'^marca/marca_form/', cadastrar_marca, name="cadastrar_marca"),
    re_path(r'^marca/marca_list/', listar_marca, name="listar_marca"),
    re_path(r'^marca/marca_remove/(?P<pk>[0-9]+)', marca_remove, name='marca_remove'),
    re_path(r'^marca/marca_produtos_list/(?P<pk>[0-9]+)', listar_produtos_marca, name='marca_produto'),
    re_path(r'^marca/marca_edit/(?P<pk>[0-9]+)', marca_edit, name='marca_edit'),
    re_path(r'^produto/produto_form/', cadastrar_produto, name="cadastrar_produto"),
    re_path(r'^produto/produto_list/', listar_produto, name="listar_produto"),
    re_path(r'^produto/produto_remove/(?P<pk>[0-9]+)', produto_remove, name='produto_remove'),
    re_path(r'^produto/produto_edit/(?P<pk>[0-9]+)', produto_edit, name='produto_edit'),
]