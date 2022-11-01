from django.urls import re_path
from .views import *

urlpatterns = [
    re_path(r'^marca/marca_form/', cadastrar_marca, name="cadastrar_marca"),
    re_path(r'^marca/marca_list/', listar_marca, name="listar_marca"),
]